package org.prog.dto;

import lombok.*;

import java.util.List;

@Data
public class ResultsDto {
    private List<UserDto> results;

    //LOMBOK REPLACES ALL OF THAT:
//    public ResultsDto(){
//
//    }
//
//    public ResultsDto(List<UserDto> results) {
//        this.results = results;
//    }
//
//    public void setResults(List<UserDto> results) {
//        this.results = results;
//    }
//
//    public List<UserDto> getResults() {
//        return results;
//    }
}
