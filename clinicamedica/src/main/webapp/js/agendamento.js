// Desabilita os campos de entrada quando a página é carregada
$(document).ready(function() {
    $('#clinica-agendamento').prop('disabled', true);
    $('#medico-agendamento').prop('disabled', true);
    $('#data-agendamento').prop('disabled', true);
    $('#horario-agendamento').prop('disabled', true);
});

$('#especialidade-agendamento').change(function () {
    var especialidade = $(this).val();
    $.get('/buscarClinicas?especialidade=' + especialidade, function (data) {
        var clinicaDropdown = $('#clinica-agendamento-list');
        clinicaDropdown.empty();
        if (data.length > 0) {
            $.each(data, function (index, clinica) {
                clinicaDropdown.append($('<option></option>').attr('value', clinica.nome));
            });
            $('#clinica-agendamento').prop('disabled', false);
        } else {
            $('#clinica-agendamento').prop('disabled', true);
        }
    });
});

$('#clinica-agendamento').change(function() {
    var especialidade = $('#especialidade-agendamento').val();
    var clinica = $(this).val();
    $.get('/buscarMedicos?especialidade=' + especialidade + '&clinica=' + clinica, function(data) {
        var medicoDropdown = $('#medico-agendamento-list');
        medicoDropdown.empty();
        if (data.length > 0) {
            $.each(data, function(index, medico) {
                medicoDropdown.append($('<option></option>').attr('value', medico.nome));
            });
            $('#medico-agendamento').prop('disabled', false);
        } else {
            $('#medico-agendamento').prop('disabled', true);
        }
    });
});

$('#medico-agendamento').change(function() {
    var medicoId = $(this).val();
    $.get('/buscarDatas?medico=' + medicoId, function(data) {
        var dataDropdown = $('#data-agendamento-list');
        dataDropdown.empty();
        if (data.length > 0) {
            $.each(data, function(index, data) {
                dataDropdown.append($('<option></option>').attr('value', data));
            });
            $('#data-agendamento').prop('disabled', false);
        } else {
            $('#data-agendamento').prop('disabled', true);
        }
    });
});

$('#data-agendamento').change(function() {
    var medico = $('#medico-agendamento').val();
    var data = $(this).val();
    $.get('/buscarHorarios?medico=' + medico + '&data=' + data, function(horarios) {
        var horarioDropdown = $('#horario-agendamento-list');
        horarioDropdown.empty();
        if (horarios.length > 0) {
            $.each(horarios, function(index, horario) {
                horarioDropdown.append($('<option></option>').attr('value', horario));
            });
            $('#horario-agendamento').prop('disabled', false);
        } else {
            $('#horario-agendamento').prop('disabled', true);
        }
    });
});
