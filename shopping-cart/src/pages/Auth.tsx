import { Button } from "react-bootstrap";

import { useEffect, useState } from "react";

const CLIENT_ID = "fe7c1c70279811b5fe4f";

type userData = {
  login: string;
  html_url: string;
  avatar_url: string;
};

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
        await fetch("https://localhost:5173/getAccessToken?code=" + codeParam, {
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
    }
  }, []);

  async function getUserData() {
    await fetch("http://localhost:5173/getUserData", {
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
          <h1>We have the access token</h1>
          <Button
            onClick={() => {
              localStorage.removeItem("accessToken");
              setRerender(!rerender);
            }}
          >
            Log out
          </Button>
          <h3>Get User Data from GitHub API</h3>
          <Button onClick={getUserData}>Get Data</Button>
          {Object.keys(userData).length !== 0 ? (
            <>
              <h4>Hey there</h4>
              {/* {userData.login}</h4>
              <img width="100px" height="100px" src={userData.avatar_url}></img>
              <a href={userData.html_url} style={{ color: "green" }}>
                Link to the GitHub profile
              </a> */}
            </>
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
