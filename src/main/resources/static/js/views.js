let url = "/";

$(document).ready(() => {
    const endpoints = {
        HOME: "/views/home",
        ACTIVITIES: "/views/activities",
        LOGIN: "/modals/loginModal.html",
        ACTIVITY: "/views/activity",
        EDIT_ACTIVITY: "/views/edit-activity",
        SIGNUP: "/modals/signupModal.html"
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
                $("#modal").modal();
                $("#modal").on('hidden.bs.modal', () => {
                    page.redirect(prev);
                    $('#modal').remove();
                })

            }
        });
    }

    const editAcitivyAuth = async () => {
        const user = await getUser();
        if (user !== null && user.role === "Employee") {
        }
    }


    page('/', (e) => {setView(endpoints.HOME); url = "/"});
    page('/login', (e) => {makeModal(endpoints.LOGIN);});
    page('/activity/:id', (e) => {setView(endpoints.ACTIVITY); url = e.path;});
    page('/signup', (e) => {makeModal(endpoints.SIGNUP);});
    page('/activities/edit/:id', (e) => {setView(endpoints.EDIT_ACTIVITY); url = e.path;});
    page('/activities', (e) => {setView(endpoints.ACTIVITIES); url = "/activities"});
    page('/logout', (e) => { logout();});



    page();


})