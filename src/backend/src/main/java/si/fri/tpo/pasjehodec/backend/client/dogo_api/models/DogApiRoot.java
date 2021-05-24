package si.fri.tpo.pasjehodec.backend.client.dogo_api.models;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class DogApiRoot implements Serializable {
    @Serial
    private static final long serialVersionUID = 7156526077883281623L;

    public DogApiWeight weight;
    public DogApiHeight height;
    public int id;
    public String name;
    public String bred_for;
    public String breed_group;
    public String life_span;
    public String temperament;
    public String origin;
    public String reference_image_id;
    public DogApiImage image;
    public String country_code;
    public String description;
    public String history;
}
