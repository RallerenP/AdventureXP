let url = "/";

$(document).ready(() => {
    const endpoints = {
        HOME: "/views/home",
        ACTIVITIES: "/views/activities",
        LOGIN: "modals/loginModal.html",
        ACTIVITY: "/views/activity"
    }


    let view;

    function setView(endpoint) {
        console.log("Previous: ", view)
        if (view === endpoint) return;
        $.ajax(endpoint, {
            type: "GET",
            success: (e) => {
                $('#content-container').html(e);
            }
        });
        view = endpoint;
        console.log("New", view)
    }

    function makeModal(endpoint) {
        const prev = url;
        $.ajax(endpoint, {
            type: "GET",
            success: (e) => {
                $(document.body).append(e);
                $("#login-modal").modal();
                $("#login-modal").on('hidden.bs.modal', () => {
                    page.redirect(prev);
                    $('#login-modal').remove();
                })

            }
        });
    }

    page('/', (e) => {setView(endpoints.HOME); url = "/"});
    page('/activities', (e) => {setView(endpoints.ACTIVITIES); url = "/activities"});
    page('/login', (e) => {makeModal(endpoints.LOGIN);});
    page('/activity', (e) => {setView(endpoints.ACTIVITY); url = "/activity"});
    page('/logout', (e) => { logout();})

    page();
})