package com.dataCreate.SpringBootBatchTasklet.Model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    private String name;

    private String gender;

    private Integer age;

    private String animal;
}
