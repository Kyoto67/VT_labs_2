package com.ifmo.cs.kyoto.alaba4.util;

import lombok.Getter;

public class ResultsPair <Result, ResultDTO>{
    @Getter
    private Result result;

    @Getter
    private ResultDTO resultDTO;

    public ResultsPair(Result result, ResultDTO resultDTO) {
        this.result = result;
        this.resultDTO = resultDTO;
    }

    public static <Result, ResultDTO> ResultsPair<Result, ResultDTO> of(Result result, ResultDTO resultDTO){
        return new ResultsPair<>(result, resultDTO);
    }

    public ResultsPair() {
    }
}