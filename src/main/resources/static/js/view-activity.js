

$(document).ready(() => {
    const activity_url = location.href;
    const activity_id = activity_url.substring(activity_url.lastIndexOf('/') + 1, activity_url.length);

    $.ajax({
        type: 'GET',
        url: `/api/activities/${activity_id}`,
        success: handleResponse,
        dataType: "json"
    });

    function handleResponse(activity) {
            const card_template = $("#activity-page-template").text();
            const compiler = _.template(card_template);
            $('#activity-container').append(compiler({ activity }));

        const getButtons = async () => {
            console.log("test")
            const button_template = $('#activity-button-template').text();

            const compiler = _.template(button_template);
            const user = await getUser();
            $('#activity-button-container').append(compiler({ user }));

            $('#update-activity-btn').click(() => {
                page(`/activities/edit/${activity_id}`)
            })
        }

        getButtons();
    }
})