package ma.yc.Mapper.impl;

import ma.yc.Mapper.Mapper;
import ma.yc.dto.ScannerDto;
import ma.yc.model.Scanner;

import java.sql.PreparedStatement;

public class ScannerMapper implements Mapper<ScannerDto, Scanner> {
    @Override
    public Scanner toEntity() {
        return null;
    }

    @Override
    public Scanner toEntity(ScannerDto scannerDto) {
        Scanner scanner = new Scanner();
        scanner.setScannerId(scannerDto.scannerId);
        scanner.setPrix(scannerDto.prix);
        scanner.setDescription(scannerDto.description);
        return scanner;
    }

    @Override
    public ScannerDto toDto() {
        return null;
    }

    @Override
    public ScannerDto toDto(Scanner scanner) {
        return null;
    }

    @Override
    public PreparedStatement toPreparedStatement(Scanner scanner, PreparedStatement preparedStatement) {
        return null;
    }
}
