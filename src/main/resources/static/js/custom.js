$.fn.DataTable.ext.pager.numbers_length = 5;

function loadDataTable(orderBy) {
    $('#datatable').DataTable({
      "pagingType": "simple_numbers",
      "lengthMenu": [
        [10, 25, 50, -1],
        [10, 25, 50, message('message.pagination.all')]
      ],
      "order" : orderBy,
      responsive: true,
      language: {
        search:            "_INPUT_",
        processing:        message('message.pagination.processing'),
        loadingRecords:    message('message.pagination.loading'),
        searchPlaceholder: message('message.pagination.search.placeholder'),
        lengthMenu:        message('message.pagination.length.menu'),
        info:              message('message.pagination.info'),
        infoEmpty:         message('message.pagination.info.empty'),
        infoFiltered:      message('message.pagination.info.filtered'),
        infoPostFix:       "",
        zeroRecords:       message('message.pagination.zero.records'),
        emptyTable:        message('message.pagination.empty.table'),
        paginate: {
            first:         message('message.pagination.paginate.first'),
            previous:      message('message.pagination.paginate.previous'),
            next:          message('message.pagination.paginate.next'),
            last:          message('message.pagination.paginate.last')
        },
        aria: {
            sortAscending: message('message.pagination.aria.sort.ascending'),
            sortDescending:message('message.pagination.aria.sort.descending')
        },
      }
    });
}

function setFormValidation(id) {
    $(id).validate({
      highlight: function(element) {
        $(element).closest('.form-group').removeClass('has-success').addClass('has-danger');
        $(element).closest('.form-check').removeClass('has-success').addClass('has-danger');
      },
      success: function(element) {
        $(element).closest('.form-group').removeClass('has-danger').addClass('has-success');
        $(element).closest('.form-check').removeClass('has-danger').addClass('has-success');
      },
      errorPlacement: function(error, element) {
        $(element).closest('.form-group').append(error);
      },
    });
}

function cleanAddressFields() {
    $("#street").val("");
    $("#neighborhood").val("");
    $("#city").val("");
    $("#state").val("");
}

function addZipCodeLoadingService() {
    $("#zipCode").blur(function() {
        var zipCode = $(this).val().replace(/\D/g, '');
        if (zipCode != "") {
            var zipCodeValid = /^[0-9]{8}$/;
            if(zipCodeValid.test(zipCode)) {
                $("#street").val("...");
                $("#neighborhood").val("...");
                $("#city").val("...");
                $("#state").val("...");
    
                $.getJSON("https://viacep.com.br/ws/"+ zipCode +"/json/?callback=?", function(result) {
                    if (!("erro" in result)) {
                        $("#street").val(result.logradouro);
                        $("#neighborhood").val(result.bairro);
                        $("#city").val(result.localidade);
                        $("#state").val(result.uf);
                    } else {
                        cleanAddressFields();
                        alert(message('message.lawfirm.address.zip.code.not.found'));
                    }
                });
            } else {
                cleanAddressFields();
                alert(message('message.lawfirm.address.zip.code.invalid'));
            }
        } else {
            cleanAddressFields();
        }
    });
}