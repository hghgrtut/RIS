/* eslint-disable jsx-a11y/alt-text */
import React from 'react'
import { useEffect, useState } from 'react'
const CLIENT_ID = "82e8de2a125e1bc044c2"

const Auth = () => {
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
          <button
            onClick={() => {
              localStorage.removeItem("accessToken");
              setRerender(!rerender);
            }}
          >
            Log out
          </button>
          <h3>We have the access token</h3>
          <button onClick={getUserData}>Show User Data</button>
          {Object.keys(userData).length !== 0 ? (
            <div>
              <div>
                <div>
                  <h2>{userData.login}</h2>
                  <img
                    width="200px"
                    height="200px"
                    src={userData.avatar_url}
                  />
                  <button href={userData.url} size="sm">
                    Link to the GitHub profile
                  </button>
                </div>
              </div>
            </div>
          ) : (
            <></>
          )}
        </>
      ) : (
        <>
          <h3>User is not logged in</h3>
          <button onClick={loginWithGithub}>Login with Github</button>
        </>
      )}
    </>
  );

}

export { Auth }
