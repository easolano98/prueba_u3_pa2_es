package com.uce.edu.demo.service;
@FunctionalInterface
public interface IReporteUnary<R,T> {
	 R aplicar (T arg1);
}
