public class Strings {
    public static void main(String[] args) {
        //String e uma cadeia de caracteres
        //String e um tipo de refêrencia e não um tipo primitivo
        //String por ser uma uma classe dentro do java tem vairios metodos

//        String name = "Fabio";
//        String name2 = "Fabio";
//
//        if(name.equals(name2)) {
//            System.out.println("The names is equals");
////            System.out.println(name.length());
//
//            for(int i = 0 ; i < name.length(); i++) {
//                //esse chatAt sabe o index de cada caracter dentro do array
//                System.out.println(name.charAt(i));
//            }
//        }
//
//        String word = "My name is Fabio and i like Java";
//        String java = "Java";
//        System.out.println(word.contains(java));
//
//        System.out.println("The names is not equals");
        String fullName = "Fabio Farias";
        System.out.println(fullName.charAt(0));
        int lastNameStart = fullName.indexOf(" ") + 1; //Encontra a posição do caracter que e passado
        System.out.println(fullName.substring(lastNameStart)); //Criaa um subString apartir de uma posicão
        System.out.println(fullName.replaceAll("F", "@"));
     }
}
