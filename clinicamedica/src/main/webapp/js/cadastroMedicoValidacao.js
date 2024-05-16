window.onload = function () {
    document.getElementById('medico-form').addEventListener('submit', function (event) {
        // Limpar mensagens de erro
        document.getElementById('confirmarEmailError').textContent = '';
        document.getElementById('confirmarSenhaError').textContent = '';
        document.getElementById('senhaError').textContent = '';
        document.getElementById('dataNascimentoError').textContent = '';

        document.getElementById('confirmarEmailError').className = 'error-message';
        document.getElementById('confirmarSenhaError').className = 'error-message';
        document.getElementById('senhaError').className = 'error-message';
        document.getElementById('dataNascimentoError').className = 'error-message';

        var email = document.getElementById('medico-email').value;
        var confirmarEmail = document.getElementById('medico-confirmar-email').value;
        var senha = document.getElementById('medico-senha').value;
        var confirmarSenha = document.getElementById('medico-confirmar-senha').value;
        var dataNascimento = document.getElementById('medico-data-nascimento').value;

        var regex = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;

        if (email !== confirmarEmail) {
            document.getElementById('confirmarEmailError').textContent = 'Os e-mails digitados não são iguais!';
            event.preventDefault();
        } else if (senha !== confirmarSenha) {
            document.getElementById('confirmarSenhaError').textContent = 'As senhas digitadas não são iguais!';
            event.preventDefault();
        } else if (!regex.test(senha)) {
            document.getElementById('senhaError').textContent = 'A senha deve ter pelo menos 8 caracteres, uma letra maiúscula e um número!';
            event.preventDefault();
        } else {
            var dataAtual = new Date();
            var dataNasc = new Date(dataNascimento);
            var idade = dataAtual.getFullYear() - dataNasc.getFullYear();
            var m = dataAtual.getMonth() - dataNasc.getMonth();
            if (m < 0 || (m === 0 && dataAtual.getDate() < dataNasc.getDate())) {
                idade--;
            }

            if (idade < 18) {
                document.getElementById('dataNascimentoError').textContent = 'Você deve ter pelo menos 18 anos para se cadastrar!';
                event.preventDefault();
            }
        }
    });

    var cpfField = document.getElementById('medico-cpf');

    cpfField.addEventListener('input', function (event) {
        var cpf = event.target.value;
        cpf = cpf.replace(/\D/g, ''); // Remove todos os caracteres que não são dígitos
        cpf = cpf.replace(/(\d{3})(\d)/, '$1.$2'); // Adiciona um ponto depois do terceiro dígito
        cpf = cpf.replace(/(\d{3})(\d)/, '$1.$2'); // Adiciona um ponto depois do sexto dígito
        cpf = cpf.replace(/(\d{3})(\d{1,2})$/, '$1-$2'); // Adiciona um traço depois do nono dígito
        event.target.value = cpf;

        if (cpf.replace(/\D/g, '').length !== 11) {
            document.getElementById('cpfError').textContent = 'CPF inválido!';
        } else {
            document.getElementById('cpfError').textContent = '';
        }
    });

    var crmField = document.getElementById('medico-crm');

    crmField.addEventListener('input', function (event) {
        var crm = event.target.value;
        crm = crm.replace(/\D/g, '');
        event.target.value = crm;

        if (crm.length !== 7) {
            document.getElementById('crmError').textContent = 'CRM inválido!';
        } else {
            document.getElementById('crmError').textContent = '';
        }
    });
}