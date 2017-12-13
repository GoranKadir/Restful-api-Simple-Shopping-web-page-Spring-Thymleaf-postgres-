$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/customers/id/1",
    }).then(function(data) {
       $('.greeting-id').append(data.customerid);
       $('.greeting-firstname').append(data.fname);
       $('.greeting-lastname').append(data.lname);
    });
});

$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/customers/findclothes/1",
    }).then(function(data) {
       $('.greeting-clothes').append(data.brandName);
    });
});