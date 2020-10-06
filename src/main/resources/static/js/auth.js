$(document).ready(() => {

})

async function getUser() {
    let user;

    const response = await fetch("/api/users");
    return response.json();
}