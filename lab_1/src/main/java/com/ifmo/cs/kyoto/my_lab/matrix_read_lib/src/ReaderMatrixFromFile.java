package com.ifmo.cs.kyoto.my_lab.matrix_read_lib.src;

import com.ifmo.cs.kyoto.my_lab.matrix_read_lib.api.Reader;
import com.ifmo.cs.kyoto.my_lab.matrix_entity.Matrix;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class ReaderMatrixFromFile implements Reader {

    private final String file;
    private final String path = System.getProperty("user.dir");
    @Override
    public Matrix read() {
        Scanner in = new Scanner(path+"/"+file);

        return null;
    }
}
