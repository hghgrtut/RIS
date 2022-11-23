import { Button, Card } from "react-bootstrap";

import { useEffect, useState } from "react";

const CLIENT_ID = "fe7c1c70279811b5fe4f";

export function Auth() {
  const [rerender, setRerender] = useState(false);
  const [userData, setUserData] = useState({});
  useEffect(() => {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const codeParam = urlParams.get("code");
    console.log(codeParam);

    if (codeParam && localStorage.getItem("accessToken") === null) {
      async function getAccessToken() {
        await fetch("http://localhost:4000/getAccessToken?code=" + codeParam, {
          method: "GET",
        })
          .then((response) => {
            return response.json();
          })
          .then((data) => {
            console.log(data);
            if (data.access_token) {
              localStorage.setItem("accessToken", data.access_token);
              setRerender(!rerender);
            }
          });
      }
      getAccessToken();
    }
  }, []);

  async function getUserData() {
    await fetch("http://localhost:4000/getUserData", {
      method: "GET",
      headers: {
        Authorization: "Bearer " + localStorage.getItem("accessToken"),
      },
    })
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        console.log(data);
        setUserData(data);
      });
  }

  function loginWithGithub() {
    window.location.assign(
      "https://github.com/login/oauth/authorize?client_id=" + CLIENT_ID
    );
  }

  return (
    <>
      {localStorage.getItem("accessToken") ? (
        <>
          <Button
            onClick={() => {
              localStorage.removeItem("accessToken");
              setRerender(!rerender);
            }}
          >
            Log out
          </Button>
          <h3>We have the access token</h3>
          <Button onClick={getUserData}>Show User Data</Button>
          {Object.keys(userData).length !== 0 ? (
            <Card className="my-5">
              <Card.Body className="d-flex flex-column">
                <div
                  className="d-flex align-items-center flex-column"
                  style={{ gap: ".5rem" }}
                >
                  <h2>{userData.login}</h2>
                  <img
                    width="200px"
                    height="200px"
                    src={userData.avatar_url}
                  ></img>
                  <Button href={userData.html_url} size="sm">
                    Link to the GitHub profile
                  </Button>
                </div>
              </Card.Body>
            </Card>
          ) : (
            <></>
          )}
        </>
      ) : (
        <>
          <h3>User is not logged in</h3>
          <Button onClick={loginWithGithub}>Login with Github</Button>
        </>
      )}
    </>
  );
}
