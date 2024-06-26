package jp.ac.ait.k22047;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class JpegCrasher {
    public static void main(String[] args) {
        crash("Baboon.jpg", "Baboon_out.jpg", 15);
    }
    /**
     * 入力されたファイルのランダムな1Byteをランダムな1bit加算で置き換えることでファイルをクラッシュさせる
     * @param input_filePath
     * @param output_filePath
     * @param challenge
     */
    public static void crash(String input_filePath, String output_filePath, int challenge) {
        byte[] bytes;

        try {
            bytes = Files.readAllBytes(Path.of(input_filePath));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        // ランダムな1ビットだけのデータを取得する
        byte[] bits = {
                (byte)0b00000001,
                (byte)0b00000010,
                (byte)0b00000100,
                (byte)0b00001000,
                (byte)0b00010000,
                (byte)0b00100000,
                (byte)0b01000000,
                (byte)0b10000000
        };
        byte value = bits[new Random().nextInt(bits.length)];

        // 1bitの値を加算して0xFFでAND演算することで1bitの変化を加える
        for(int i = 0; i < challenge; i++) {
            int randomIndex = new Random().nextInt(bytes.length);
            bytes[randomIndex] = (byte) ((int) bytes[randomIndex] + (int) value & 0xFF);
        }

        try {
            Files.write(Path.of(output_filePath), bytes);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
