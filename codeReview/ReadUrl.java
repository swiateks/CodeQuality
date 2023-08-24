public class ReadUrl { 

  public static void main(String[] args){ 
   System.out.println("Reading URL");
    readFromURL();
  }
    public void readFromURL() {
      try {
          URL url = new URL("http://example.com");
          URLConnection urlConnection = url.openConnection();
          InputStream is = urlConnection.getInputStream();
          byte[] bytes = is.readAllBytes();
      } catch (IOException ioe) {
          ioe.printStackTrace();
      }
  }
}
