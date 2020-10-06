$(document).ready(() => {

})

async function getUser() {
    let user;

    const response = await fetch("/api/users");

    if (response.status === 401) return null;
    else return response.json();
}

function logout() {
    $.ajax("/api/users/logout", { type: "GET", success: () =>  window.location = "/" });
}