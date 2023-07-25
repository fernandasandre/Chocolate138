package entities;

import java.util.ArrayList;

public class PetEntity {
    public int id;
    public CategoryEntity category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<TagEntity> tags;
    public String status;
}
