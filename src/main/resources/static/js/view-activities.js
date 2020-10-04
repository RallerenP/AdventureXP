$(document).ready(() => {
    const card_template = $("#activity-card").text();

    $.ajax({
        type: 'GET',
        url: '/api/activities',
        success: handleResponse,
        dataType: "json"
    });

    function handleResponse(activities) {
        for (const activity of activities) {
            console.log(activity)
            const compiler = _.template(card_template);
            $('#card-container').append(compiler({ activity }));
        }
    }
})