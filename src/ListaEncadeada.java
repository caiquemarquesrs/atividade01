class ListaEncadeada<T> {
    No<T> inicio;
    public ListaEncadeada() {
        this.inicio = null;
    }
    public void inserirNoInicio(T dado) {
        No<T> novoNo = new No<>(dado);
        novoNo.proximo = this.inicio;
        this.inicio = novoNo;
    }
    public boolean buscar(T alvo) {
        No<T> atual = this.inicio;
        while (atual != null) {
            if (alvo.equals(atual.dado)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
    public void removerDuplicatasSimples() {
        No<T> noExterno = this.inicio;
        while (noExterno != null) {
            No<T> corredor = noExterno;
            while (corredor.proximo != null) {
                if (corredor.proximo.dado.equals(noExterno.dado)) {
                    corredor.proximo = corredor.proximo.proximo;
                } else {
                    corredor = corredor.proximo;
                }
            }
            noExterno = noExterno.proximo;
        }
    }
    public void exibir() {
        if (this.inicio == null) {
            System.out.println("Lista Vazia");
            return;
        }
        No<T> atual = this.inicio;
        StringBuilder sb = new StringBuilder();
        while (atual != null) {
            sb.append(String.valueOf(atual.dado)).append(" -> ");
            atual = atual.proximo;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
    /**
     * Justificativa: a operação consiste apenas em atualizar a referência
     * "inicio" para apontar para o próximo nó. Não há necessidade de percorrer
     * a lista, portanto o tempo é constante, independente do tamanho da lista.
     */

    public void removerDoInicio() {
        if (this.inicio == null) {
            return;
        }
        this.inicio = this.inicio.proximo;
    }
    /**Justificativa: para acessar o elemento na posição desejada, é necessário
     * percorrer a lista nó a nó a partir do início até o índice especificado.
     * No pior caso (último elemento), percorremos todos os n nós, logo o custo é O(n).*/

    public T obterEm(int indice) {
        if (indice < 0) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        No<T> atual = this.inicio;
        int contador = 0;
        while (atual != null) {
            if (contador == indice) {
                return atual.dado;
            }
            atual = atual.proximo;
            contador++;
        }
        throw new IndexOutOfBoundsException("Índice fora dos limites: " + indice);
    }
    /**
     * Justificativa: no pior caso, é necessário percorrer toda a lista
     * para encontrar a primeira ocorrência do valor ou concluir que ele
     * não está presente. Esse percurso percorre até n nós, logo o custo é O(n).
     */

    public void removerValor(T dado) {
        if (this.inicio == null) {
            return;
        }
        if (this.inicio.dado.equals(dado)) {
            this.inicio = this.inicio.proximo;
            return;
        }
        No<T> anterior = this.inicio;
        No<T> atual = this.inicio.proximo;
        while (atual != null) {
            if (atual.dado.equals(dado)) {
                anterior.proximo = atual.proximo;
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }
    }
    /**
     * Justificativa: no pior caso, é necessário percorrer a lista inteira
     * a partir do início até encontrar o último nó. Esse percurso percorre
     * até n nós, logo o custo é linear no tamanho da lista.
     */

    public void inserirNoFim(T dado) {
        No<T> novoNo = new No<>(dado);
        if (this.inicio == null) {
            this.inicio = novoNo;
            return;
        }
        No<T> atual = this.inicio;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }
    /**
     * Justificativa: é necessário percorrer todos os nós da lista para contar cada elemento.
     * No pior caso, percorremos n nós, então o custo é linear no tamanho da lista.
     */

    public int tamanho() {
        int contador = 0;
        No<T> atual = this.inicio;
        while (atual != null) {
            contador++;
            atual = atual.proximo;
        }
        return contador;
    }
}