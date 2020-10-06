$(document).ready(() => {
    const card_template = $("#activity-card").text();

    $.ajax({
        type: 'GET',
        url: '/api/activities/2',
        success: handleResponse,
        dataType: "json"
    });

    function handleResponse(activity) {
            const card_template = $("#activity-card").text();
            const compiler = _.template(card_template);
            $('#activity-container').append(compiler({ activity }));

        const getButtons = async () => {
            console.log("test")
            const button_template = $('#activity-button-template').text();

            const compiler = _.template(button_template);
            const user = await getUser();
            $('#activity-button-container').append(compiler({ user }));
        }

        getButtons();
    }
})