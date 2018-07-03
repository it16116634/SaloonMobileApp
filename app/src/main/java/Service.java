public class Service {
    private String Image;
    private String Price;
    private String ServiceName;

public Service()
{

}

    public Service(String image, String price, String serviceName) {
        Image = image;
        Price = price;
        ServiceName = serviceName;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }
}
