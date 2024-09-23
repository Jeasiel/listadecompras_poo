document.addEventListener('DOMContentLoaded', function () {
    // Função para lidar com exclusão
    const deleteButtons = document.querySelectorAll('.delete-btn');
    deleteButtons.forEach(button => {
        button.addEventListener('click', function () {
            const listId = this.getAttribute('data-id');
            if (confirm('Tem certeza que deseja excluir essa lista?')) {
                // Lógica para excluir a lista usando o ID (você pode fazer isso com uma chamada ao servidor)
                console.log(`Lista com ID ${listId} excluída!`);
                // Exclua a lista do DOM
                this.parentElement.remove();
            }
        });
    });

    // Função para lidar com edição
    const editButtons = document.querySelectorAll('.edit-btn');
    editButtons.forEach(button => {
        button.addEventListener('click', function () {
            const listId = this.getAttribute('data-id');
            // Redirecionar para a página de edição com o ID da lista
            window.location.href = `edit-list.html?listId=${listId}`;
        });
    });
});
