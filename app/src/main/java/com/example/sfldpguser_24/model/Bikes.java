package com.example.sfldpguser_24.model;

/**
 * Created by SFLDPGUSER-24 on 3/2/2018.
 */
//@XmlRootElement(name = "bikes")
public class Bikes {
        private String nameOfStation;
   // private String free_bikes = "";
//    private String id;
//    private String latitude;
//    private String longitude;
      public Bikes() {
      }
    // getter

    public Bikes(String nameOfStation) {
        super();
        this.nameOfStation = nameOfStation;
    }

    /**
     * @return the id
     */
    public String nameOfStation() {
        return nameOfStation;
    }

    /**
     * @param nameOfStation the empty_slots to set
     */
    public void setnameOfStation(String nameOfStation) {
        this.nameOfStation = nameOfStation;
    }

//    /**
//     * @return the name
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * @param name the name to set
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    /**
//     * @return the author
//     */
//    public String getAuthor() {
//        return author;
//    }
//
//    /**
//     * @param author the author to set
//     */
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see java.lang.Object#toString()
//     */
    @Override
    public String toString() {
        return "Bike [nameOfStation=" + nameOfStation + "]";
    }

}


