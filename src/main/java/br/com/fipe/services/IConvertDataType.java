package br.com.fipe.services;

public interface IConvertDataType {
    <T> T obterDados(String json, Class<T> classe);
}
