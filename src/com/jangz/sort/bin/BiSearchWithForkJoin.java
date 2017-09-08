package com.jangz.sort.bin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class BiSearchWithForkJoin extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3336653511071960347L;
	
	private final int threshold;
	private final BinarySearchProblem problem;
	private int result;
	private final int numberToSearch;
	
	
	
	public BiSearchWithForkJoin(BinarySearchProblem problem, int threshold, int numberToSearch) {
		this.problem = problem;
		this.threshold = threshold;
		this.numberToSearch = numberToSearch;
	}

	@Override
	protected void compute() {
		if (problem.size < threshold) {
			// С�ڷ�ֵ����ֱ������ͨ�Ķ��ֲ���
			result = problem.searchSequentially(numberToSearch);
		} else {
			// �ֽ�������
			int midPoint = problem.size / 2;
			BiSearchWithForkJoin left = new BiSearchWithForkJoin(problem.subProblem(0, midPoint), threshold, numberToSearch);
			BiSearchWithForkJoin right = new BiSearchWithForkJoin(problem.subProblem(midPoint + 1, problem.size - 1), threshold, numberToSearch);
			invokeAll(left, right);
			result = Math.max(left.result, right.result);
		}
	}
	
	// ��������
	private static final int[] data = new int[10_000_000];
	static {
		for (int i = 0; i < 10_000_000; i++) {
			data[i] = i;
		}
	}
	
	public static void main(String[] args) {
		BinarySearchProblem problem = new BinarySearchProblem(data, 0, data.length);
		int threshold = 100;
		int nThreads = 10;

		// ����10_000_000���ڵ��±�
		BiSearchWithForkJoin biSearchWithForkJoin = new BiSearchWithForkJoin(problem, threshold, 100_0000);
		ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
		forkJoinPool.invoke(biSearchWithForkJoin);
		System.out.printf("Result is: %d%n", biSearchWithForkJoin.result);
	}
	
}
