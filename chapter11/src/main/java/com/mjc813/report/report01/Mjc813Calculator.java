package com.mjc813.report.report01;

public class Mjc813Calculator {

    public long strongSum(Integer ... arrs){
        if(arrs == null){
            return 0L;
        }
        long result = 0L;
        for(Integer item : arrs){
            result += item == null ? 0 : item;
        }
        return result;
    }

	public Long sum( Integer ... arrs ) throws ArrsNullException, ArrsElementIsNullException {
        Long result = 0L;
        // arrs 값들의 모든 합을 구해야 합니다.
        // 다만 arrs 배열이 null 일 수 있으므로 예외처리를 이곳이든 이곳을 호출하는 메소드에서든 꼭 해야 합니다.
		if(arrs == null){
            throw new ArrsNullException("ArrsNullException 예외 발생");
        }
        for(Integer arr : arrs){
            result += arr;
        }
		return result;
	}

	public Long sum(Integer[] arrs, Integer start, Integer end) throws ArrsNullException, ArrsElementIsNullException, ArrsStartOverIndexOutOfBoundsException, ArrsEndOverIndexOutOfBoundsException{
		Long result = 0L;
        if(arrs == null){
            throw new ArrsNullException("ArrsNullException 예외 발생");
        }
        if(start == null){
            throw new NullPointerException("NullPointerException 예외발생");
        }
        if(start < 0) {
            throw new ArrsStartOverIndexOutOfBoundsException("ArrsStartOverIndexOutOfBoundsException 예외발생");
        }
        if(end == null){
            throw new NullPointerException("NullPointerException 예외발생");
        }
        if(end >= arrs.length){
            throw new ArrsEndOverIndexOutOfBoundsException ("ArrsEndOverIndexOutOfBoundsException 예외발생");
        }
        for(int i = start; i <= end; i++){
            if(arrs[i] == null){
                throw new ArrsElementIsNullException("ArrsElementIsNullException 예외발생");
            }
            result += arrs[i];
        }
		// arrs 배열중에서 start ~ end 인덱스 까지의 원소들의 모든 합을 구해야 합니다.
		// 다만 arrs 배열이 null 일 수 도 있고, 원소가 null 일 수도 있고
		// 배열 인덱스 start ~ end 가 문제가 생길 수 도 있습니다.
		// 그러므로 예외처리를 꼭 해야 합니다.
		return result;
	}
}
