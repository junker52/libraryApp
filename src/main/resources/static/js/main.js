/**
 * Created by HP on 08/04/2018.
 */

$(document).ready(function() {
    //Locale changing
    $(".lang-option").click(function () {
        var selectedOption = $(this).text().toLocaleLowerCase();
        var currentUrl = location.href;
        if(currentUrl.indexOf("lang") > -1){
            var temp_url = currentUrl.split("?");
            currentUrl = temp_url[0];
        }
        location.replace(currentUrl+("?lang="+selectedOption));
    });
});
