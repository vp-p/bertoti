function uuidv4() {
    return ([1e7] + -1e3 + -4e3 + -8e3 + -1e11).replace(/[018]/g, c =>
        (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    );
}


function openModal() {
    document.getElementById('id01').style.display = 'block';
    document.getElementById('nomeLivro').value = '';
    document.getElementById('qtdPaginas').value = '';
    document.getElementById('inputID').value = uuidv4();
}


function closeModal() {
    document.getElementById('id01').style.display = 'none';
}

document.getElementById('submitBtn').addEventListener('click', function() {
    const inputID = document.getElementById('inputID').value;
    const nomeLivro = document.getElementById('nomeLivro').value.trim();
    const qtdPaginas = parseInt(document.getElementById('qtdPaginas').value) || 0;

    if (!nomeLivro) {
        alert("⚠️ Por favor, insira o nome do livro.");
        return;
    }

    axios.post('http://localhost:8080/books', {
        id: inputID,
        name: nomeLivro,
        pages: qtdPaginas
    })
    .then(response => {
        alert("✅ Livro adicionado com sucesso!");
        closeModal();
        loadBooks(); 
    })
    .catch(error => {
        console.error("Erro ao adicionar livro:", error);
        alert("❌ Erro ao adicionar livro. Verifique o console.");
    });
});


document.addEventListener("DOMContentLoaded", loadBooks);

function loadBooks() {
    const bookList = document.getElementById("book-list");
    bookList.innerHTML = '<div class="text-center py-4">Carregando livros...</div>';

    axios.get('http://localhost:8080/books')
        .then(response => {
            bookList.innerHTML = '';

            if (response.data.length === 0) {
                bookList.innerHTML = '<div class="alert alert-info">Nenhum livro cadastrado ainda.</div>';
                return;
            }

            response.data.forEach(book => {
                const listItem = document.createElement("li");
                listItem.className = "list-group-item book-item";

                const bookInfo = document.createElement("div");
                bookInfo.innerHTML = `
                    <strong>${book.name}</strong><br>
                    <small class="text-muted">ID: ${book.id} | Páginas: ${book.pages || 0}</small>
                `;

                const actionsDiv = document.createElement("div");
                actionsDiv.className = "action-buttons mt-2";

                const editInput = document.createElement("input");
                editInput.type = "text";
                editInput.className = "form-control form-control-sm edit-input";
                editInput.placeholder = "Novo nome";
                editInput.value = book.name;

                
                const editButton = document.createElement("button");
                editButton.innerHTML = "✏️ Editar";
                editButton.className = "btn btn-sm btn-outline-primary";
                let isEditing = false;

                editButton.addEventListener('click', () => {
                    if (!isEditing) {
                        editInput.style.display = 'inline-block';
                        editButton.innerHTML = "💾 Salvar";
                        isEditing = true;
                    } else {
                        const newName = editInput.value.trim();
                        if (newName) {
                            axios.put(`http://localhost:8080/books/${book.id}`, {
                                id: book.id,
                                name: newName,
                                pages: book.pages
                            })
                            .then(response => {
                                bookInfo.innerHTML = `
                                    <strong>${newName}</strong><br>
                                    <small class="text-muted">ID: ${book.id} | Páginas: ${book.pages || 0}</small>
                                `;
                                editInput.style.display = 'none';
                                editButton.innerHTML = "✏️ Editar";
                                isEditing = false;
                                alert("✅ Livro atualizado!");
                            })
                            .catch(error => {
                                console.error("Erro ao atualizar:", error);
                                alert("❌ Erro ao atualizar livro.");
                            });
                        }
                    }
                });

                
                const deleteButton = document.createElement("button");
                deleteButton.innerHTML = "🗑️ Excluir";
                deleteButton.className = "btn btn-sm btn-outline-danger";

                deleteButton.addEventListener('click', () => {
                    if (confirm(`Tem certeza que deseja excluir "${book.name}"?`)) {
                        axios.delete(`http://localhost:8080/books/${book.id}`)
                            .then(() => {
                                listItem.remove();
                                alert("✅ Livro excluído!");
                            })
                            .catch(error => {
                                console.error("Erro ao excluir:", error);
                                alert("❌ Erro ao excluir livro.");
                            });
                    }
                });

                // Append elements
                actionsDiv.appendChild(editInput);
                actionsDiv.appendChild(editButton);
                actionsDiv.appendChild(deleteButton);

                listItem.appendChild(bookInfo);
                listItem.appendChild(actionsDiv);
                bookList.appendChild(listItem);
            });
        })
        .catch(error => {
            console.error("Erro ao carregar livros:", error);
            bookList.innerHTML = '<div class="alert alert-danger">❌ Erro ao carregar livros. Verifique o backend.</div>';
        });
}