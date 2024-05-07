$('#especialidade-agendamento').change(function () {
    var especialidade = $(this).val();
    $.get('/buscarClinicas?especialidade=' + especialidade, function (data) {
        var clinicaDropdown = $('#clinica-agendamento-list');
        clinicaDropdown.empty();
        $.each(data, function (index, clinica) {
             clinicaDropdown.append($('<option></option>').attr('value', clinica.nome));
            });
    });
});

$('#clinica-agendamento').change(function() {
    var especialidade = $('#especialidade-agendamento').val();
    var clinica = $(this).val();
    $.get('/buscarMedicos?especialidade=' + especialidade + '&clinica=' + clinica, function(data) {
        var medicoDropdown = $('#medico-agendamento-list');
        medicoDropdown.empty();
        $.each(data, function(index, medico) {
            medicoDropdown.append($('<option></option>').attr('value', medico.nome));
        });
    });
});

$('#medico-agendamento').change(function() {
    var medicoId = $(this).val();

    $.get('/buscarDatas?medico=' + medicoId, function(data) {
        var dataDropdown = $('#data-agendamento-list');
        dataDropdown.empty();
        $.each(data, function(index, data) {
            dataDropdown.append($('<option></option>').attr('value', data));
        });
    });
});

$('#data-agendamento').change(function() {
    var medico = $('#medico-agendamento').val();
    var data = $(this).val();

    $.get('/buscarHorarios?medico=' + medico + '&data=' + data, function(horarios) {
        var horarioDropdown = $('#horario-agendamento-list');
        horarioDropdown.empty(); // Mudança aqui: corrigindo o nome da variável
        $.each(horarios, function(index, horario) { // Mudança aqui: corrigindo o nome da variável
            horarioDropdown.append($('<option></option>').attr('value', horario));
        });
    });
});
