let url = "/";

$(document).ready(() => {
    const endpoints = {
        HOME: "/views/home",
        ACTIVITIES: "/views/activities",
        EDIT_ACTIVITY: "/views/edit-activity",
        LOGIN: "modals/loginModal.html"
    }


    let view;

    function setView(endpoint) {
        if (view === endpoint) return;
        $.ajax(endpoint, {
            type: "GET",
            success: (e) => {
                $('#content-container').html(e);
            },
        });
        view = endpoint;
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
    page('/login', (e) => {makeModal(endpoints.LOGIN);});
    page('/activities/edit/:id', (e) => {setView(endpoints.EDIT_ACTIVITY); url = "/activities/edit/"});
    page('/activities', (e) => {setView(endpoints.ACTIVITIES); url = "/activities"});
    page('/logout', (e) => { logout();})

    page();
})