package myJmeter;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello world");
        System.out.println(Base64.encode("hello world".getBytes()));
        System.out.println("hello world");

//        Map<String,String> result = RSAUtils.createKeys(512);
//        System.out.println(result.get("publicKey"));
//        System.out.println(result.get("privateKey"));

        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7RvxgHItApsWkHpY0x0G\n" +
                "30M7CI02NZrxmElgaFZ6yS7bKpTVHPdJlQsB6g/f5l3a7oU1NtM5xMtfAVw3bRGL\n" +
                "g2rt4lU+bJOG+yh1SuW8PWz4QfKTuM/zcd1UXYgVXaRWolSvuPbDDGXgJq4NrBXc\n" +
                "bBWBQNnzgZDrwcDBErHY+8Fokv1vTdwGGDg3eUdRN6+m4VPW4IhZIJJEnj3BUqsX\n" +
                "6CDqteMPbVQAj7bNy3yVBbAoZuFDUrhkQiwrODjRu0eCcJhDhdEtQJYh7b1WKuWb\n" +
                "JezGJsjtu3jbC0YFY2ZD21sU8OfWWRIAeEUscucyldd+b0e6xeYRPTHrz305VMw9\n" +
                "FwIDAQAB";

        String priKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDtG/GAci0CmxaQ\n" +
                "eljTHQbfQzsIjTY1mvGYSWBoVnrJLtsqlNUc90mVCwHqD9/mXdruhTU20znEy18B\n" +
                "XDdtEYuDau3iVT5sk4b7KHVK5bw9bPhB8pO4z/Nx3VRdiBVdpFaiVK+49sMMZeAm\n" +
                "rg2sFdxsFYFA2fOBkOvBwMESsdj7wWiS/W9N3AYYODd5R1E3r6bhU9bgiFkgkkSe\n" +
                "PcFSqxfoIOq14w9tVACPts3LfJUFsChm4UNSuGRCLCs4ONG7R4JwmEOF0S1AliHt\n" +
                "vVYq5Zsl7MYmyO27eNsLRgVjZkPbWxTw59ZZEgB4RSxy5zKV135vR7rF5hE9MevP\n" +
                "fTlUzD0XAgMBAAECggEBAMKEyyJKCNz7aI6MoLRJOusMl7CTUKa3f34krF/MmpzT\n" +
                "wN91DETgJlCMoDxqW4/87XACfj6FGP52rXFLOvlSjHb60T9+GWEvwmvnrBoO0Ng/\n" +
                "voczv7a9ewWtwtmcm5KgEKbJ/QMsBaX1KefxoKvNn3BYUBpo85kW0CK6xGpW1yDo\n" +
                "3SlJt0m8d1tbNZpXPjcV/f6cDeIFuGC2evmJZ50RiSHIgxtZFTMih1DhAWWH8VXP\n" +
                "A4Zj8+BcR+8u6Helkra5d1UPMv7N0qIb7DbxV/h9gqKJLYUA7zcRHcUl5QJAFRpU\n" +
                "oLkozVBl4RnEbYdb/24Qtfp/c3bD4i9Exfp2pRqQlWkCgYEA/x4LPwRRWFW04+lo\n" +
                "OuuUG5XS2PwXg66juNAy3c0ns7BvTEutyo5usy3Xe9IbTLSlWSg+QLlu856tHpKu\n" +
                "J02pdjmxX7RU0zBeqtHSyGZOqgdSME+VCc3m+naRSf1vzST3o7+aBj0MUJOqqtR1\n" +
                "zJDYKhBb4aeaLdRC9Gagm86w+7UCgYEA7e3zHUcBSUxvgTA/axjs95T99qjJSlFd\n" +
                "NW/F90PbU0A+CiOMDbe3BgLFJ5g2E97I1oEEzy7aaSukOoLb5jnZk0LkvMsYw4VB\n" +
                "aRFxb9fKUUR8p41qu1iXdV7cNpwl0wVdA5DSNm/k+m0DHAZNXpnSKrneMArlhtKS\n" +
                "Sv2+tezjjRsCgYEA8CFgZo1y39m0bX5KbINHontwvmry2zDrzE60QlAT2a/t4vus\n" +
                "9ucATcmNdW/74ER9CqG1jwi75bXqr8dTA423P5/oU/QSj8KMqO7dH2IlEyfW9cBC\n" +
                "wbq8ee5WrTVPIeJ08f2sRcj6qXGFCEz5IHcJ8PX69jjjB9Yuu4tKC74Omq0CgYEA\n" +
                "vNlraEedm8JRlubmz2jfXbwiwA9EhfqC0xE+vn5brX6GP6HrXk/9s4WrWzwTYD4q\n" +
                "hyes243CyktbdR280MYGDj7AM6G4rCguvOidczqCWXLUxmEW4FD3FrAOdkIGO7I8\n" +
                "G8JtN8wkoSi5mRrfekD5cfRJiTR87kBg4aj6IIhALRUCgYBmG8p9ywY/zrcAK53s\n" +
                "Z/BoiUetra0fMYblyFPvYwOV45E20yfPzYP1jmPHo6/H2KiGBBLWGOZOupLzVwTP\n" +
                "Vbug/b/YnhFG7EboFNckyo4U3d5/VhEq49WAgv9Lu7Y3g5UVRYBlYoiOQ+7qgE9w\n" +
                "A1KK48k6c+vcg4geeo/VF9S3OA==";
        try {
           String result0 =  "frtkGlwZZcV14fpsJsC15xxLlHq7zVbRnLCuQG820748MFVsuRFYeQ1/ADYjhFofVU+RONmGTTWe5A2exVHYp1jEqCLf3M6zkOxsTJ1J12Cz23HeW3N0fL/1BISsTxosPCK8AD0eD7d+5zCgSVCYF5425NyKje3EVPl08uNp872Ar9mPEibz/f0rIJvm3j87GD6sjAQC0AxrM7S/3KkVdnYGL1Jzl0pmiYLtGvrQYTrUs5GsRYds2gpEN8iFMvnS9J9tirNwDTiEIxFWmaho3EQgXge6LcqVIiovqDteh1lGd6c5j0Ae2NE/3kqskjHX+8vAXw+oyf526RxcJADwuw==";
           XRsa client = new XRsa(publicKey,priKey);
           String result =  client.publicEncrypt("hello");
           System.out.println(result0);
           System.out.println(result);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
