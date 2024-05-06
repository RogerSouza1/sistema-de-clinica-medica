$('#especialidade-agendamento').change(function () {
    var especialidade = $(this).val();
    $.get('/buscarClinicas', {especialidade: especialidade}, function (data) {
        var clinicaDropdown = $('#clinica-agendamento');
        clinicaDropdown.empty();
        $.each(data, function (index, clinica) {
            clinicaDropdown.append(new Option(clinica.nome, clinica.id));
        });
    });
});

$('#clinica-agendamento').change(function () {
    var clinica = $(this).val();
    var especialidade = $('#especialidade-agendamento').val();
    console.log("Clinica selecionada: " + clinica);
    console.log("Especialidade selecionada: " + especialidade);
    $.get('/buscarMedicos', {clinica: clinica, especialidade: especialidade}, function (data) {
        console.log("Dados retornados para buscarMedicos: ", data);
        var medicoDropdown = $('#medico-agendamento');
        medicoDropdown.empty();
        $.each(data, function (index, medico) {
            medicoDropdown.append($('<option></option>').attr('value', medico.id).text(medico.nome));
        });
    });
});

$('#medico-agendamento').change(function () {
    var medicoId = $(this).val();
    console.log("Medico selecionado: " + medicoId);
    $.get('/buscarDatas', {medicoId: medicoId}, function (data) {
        console.log("Dados retornados para buscarDatas: ", data);
        var dataDropdown = $('#data-agendamento');
        dataDropdown.empty();
        $.each(data, function (index, data) {
            dataDropdown.append($('<option></option>').attr('value', data).text(data));
        });
    });
});

$('#data-agendamento').change(function () {
    var data = $(this).val();
    var medicoId = $('#medico-agendamento').val();
    console.log("Data selecionada: " + data);
    console.log("Medico selecionado: " + medicoId);
    $.get('/buscarHorarios', {medicoId: medicoId, data: data}, function (horarios) {
        console.log("Dados retornados para buscarHorarios: ", horarios);
        var horarioDropdown = $('#horario-agendamento');
        horarioDropdown.empty();
        $.each(horarios, function (index, horario) {
            horarioDropdown.append($('<option></option>').attr('value', horario).text(horario));
        });
    });
});

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