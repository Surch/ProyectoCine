/*   
Template Name: Color Admin - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.4
Version: 1.7.0
Author: Sean Ngu
Website: http://www.seantheme.com/color-admin-v1.7/admin/
*/

var handleJqueryFileUpload = function() {
     // Initialize the jQuery File Upload widget:
    /*Tamaño máximo por defecto es 10 * 1024 * 1024 y los ficheros aceptados para la subida son los de la variable acceptFileTypes*/
    $('#fileupload').fileupload({
        autoUpload: false,
        disableImageResize: /Android(?!.*Chrome)|Opera/.test(window.navigator.userAgent),
        maxFileSize: 10 * 1024 * 1024 * 1024,
        acceptFileTypes: /(\.|\/)(gif|jpe?g|png|pdf|doc|docx|ppt|pptx|pps|ppsx|odt|xls|xlsx|mp4|avi|mpe?g|mov|wmv|3gp)$/i,
        // Uncomment the following to send cross-domain cookies:
        //xhrFields: {withCredentials: true},                
    });

    // Enable iframe cross-domain access via redirect option:
    $('#fileupload').fileupload(
        'option',
        'redirect',
        window.location.href.replace(
            /\/[^\/]*$/,
            '/cors/result.html?%s'
        )
    );

    // Upload server status check for browsers with CORS support:
    if ($.support.cors) {
        $.ajax({
            type: 'HEAD'
        }).fail(function () {
            $('<div class="alert alert-danger"/>').text('El servidor no está disponible - ' + new Date()).appendTo('#fileupload');
        });
    }

    // Load & display existing files:
    $('#fileupload').addClass('fileupload-processing');
    $.ajax({
        // Uncomment the following to send cross-domain cookies:
        //xhrFields: {withCredentials: true},
        url: $('#fileupload').fileupload('option', 'url'),
        dataType: 'json',
        context: $('#fileupload')[0]
    }).always(function () {
        $(this).removeClass('fileupload-processing');
    }).done(function (result) {
        $(this).fileupload('option', 'done')
        .call(this, $.Event('done'), {result: result});
    });
};


var FormMultipleUpload = function () {
	"use strict";
    return {
        //main function
        init: function () {
            handleJqueryFileUpload();
        }
    };
}();