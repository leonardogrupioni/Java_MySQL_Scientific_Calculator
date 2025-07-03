use calculadora;

-- verificar todas as operacoes
select * from operacoes;

-- verificar todas as operacoes realizadas na calculadora basica
select * from operacoes where calculadora = 'basica';

-- verificar todas as operacoes realizadas na calculadora cientifica
select * from operacoes where calculadora = 'cientifica';

-- verificar todas as operacoes que deram failure trazendo a mensagem contendo o log com erro
select * from operacoes where status = 'failure';

-- verificar todas as operacoes de raiz quadrada
select * from operacoes where operador = 'sqrt';

-- verificar quantas operacoes foram realizadas trazendo a quantidade de operacoes com status = sucess e a qtd com status = failure
SELECT
    COUNT(*) AS total_operacoes,
    SUM(CASE WHEN status = 'success' THEN 1 ELSE 0 END) AS total_sucesso,
    SUM(CASE WHEN status = 'failure' THEN 1 ELSE 0 END) AS total_falhas
FROM operacoes;
