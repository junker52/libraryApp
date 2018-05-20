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


$(document).ready(function() {
    //Showing Modal
    $(".modal-class").click(function () {
        var selectedId = $(this).attr('id');
        $("#reserva-model").load("/libro/"+selectedId+"/reserva", function () {
            $('#reservaModal').modal('show');
            validationReserva();
        })
    });

    function validationReserva() {
        //Validation form
        $('#validarReserva').click(function() {
            console.log("Bloqueo de submit");
            var datesJson = buildValidationJSON();
            console.log(JSON.stringify(datesJson));
            sendValidationJson(datesJson);
        });
    }

    function buildValidationJSON() {

        var fechaDesde = $('#fechaDesdeInput').val();
        var fechaHasta = $('#fechaHastaInput').val();
        var reservaDates = {'fechaDesde': fechaDesde, 'fechaHasta': fechaHasta};
        return reservaDates;
    }

    function sendValidationJson(validationJson) {
        $.ajax({
            url: window.location.origin+'/validateReserva',
            type: 'POST',
            data: JSON.stringify(validationJson),
            contentType: 'application/json',
            dataType: 'json',
            async: true,
            success: function(msg) {
                if (msg.valid == false){
                    displayErrors(msg.errorMessages);
                } else {
                    $('#reservaModalForm').submit();

                }
            }
        });
    }
    
    function displayErrors(errorMessages) {
        if(errorMessages instanceof Array && errorMessages.length > 0){
            errorMessages.forEach(function (elemento, indice, array) {
                console.log(elemento, indice);
                $("#alertValidationReservaDiv").append("<p> "+elemento+" </p>")
            });
        }
        //Activamos el display de alerta
        $("#alertValidationReservaDiv").removeClass("d-none");
    }

    // Hover for devolver and prorrogar links
    $("[class='btn btn-outline-danger text-danger']").hover(function () {
        //Hover in function
        $(this).removeClass('text-danger').addClass('text-white');
    }, function () {
        //hover out function
        $(this).removeClass('text-white').addClass('text-danger');
    });

    $("[class='btn btn-outline-warning text-warning']").hover(function () {
        //Hover in function
        $(this).removeClass('text-warning').addClass('text-white');
    }, function () {
        //hover out function
        $(this).removeClass('text-white').addClass('text-warning');
    });

});




