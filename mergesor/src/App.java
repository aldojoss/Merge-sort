//Aldo Aviles
//1M7s
//2024-1632U


import java.util.Scanner;

public class App {

    static int []arrai;
    static int tamano;

    public static void main(String[] args) throws Exception {

    Scanner leer= new Scanner (System.in);
       
// do y try para q ingrese el tamano del vector sin errores
do {
    try {
        System.out.println("ingrese el tamano de su vector");
tamano=leer.nextInt();
arrai=new int[tamano];
break;
} catch (Exception e) {
    System.out.println(e);
System.out.println(" valor invalido INTENTE DE NUEVO");
leer.nextLine();
}
} while (true);

     
//do para q ingrese los valores del vector sin errores con try cathc y do
do {
try {
    
for (int i =0;i<tamano;i++){
System.out.println("Ingrese el valor "+(i+1));
arrai[i]=leer.nextInt();
}
break;

} catch (Exception e) {
    System.out.println(e);
    System.out.println(" Valor invalido VUELVA A INGRESAR LOS DATOS");
}
} while (true);

System.out.println("Enteros ingresados por usted");
System.out.println("_____________________________");

for(int i=0;i<tamano;i++){
System.out.println(arrai[i]);
}
//AQUI SOLO LLAMAMOS AL METODO para ordenar los datos 
App ap = new App();
int[] ordenado= ap.Mergesort(arrai);
System.out.println("______________________________");
System.out.println("Enteros ordenados");
for (int i =0;i<arrai.length;i++){
System.out.println(ordenado[i]);

}


    }

public int [] Mergesort (int[] A) { //ordenar ela arreglo de numeros a

    if (A.length<=1) {
        return A;
    }

int []izquierda;
int[] derecha;

derecha = new int[A.length/2]; // aqui derecha siempre va a ser la mitad y al que le asignaremos mas valores es a izq


if (A.length % 2==0) { // si el tamano maximo del arreglo es par
izquierda= new int[A.length/2]; // entonces el subarreglo de la izquierda va a tener la mitad
}else {
    izquierda= new int[A.length/2 +1]; // si no va a tener la mayor parte 
}


// en el codigo de arriba simplemente definimos cual subarreglo tendra mas tamano por si acaso la cantidad de numeros es impar uno tendria q tener mas

int i;
for (i=0;i<izquierda.length;i++){  // primero declaramos una variable i porque depsues la vamos a usar
                            // hacemos nun for que recorra todo el arreglo de la izquierda hasta que sea menor que la cantidad maxima de la izquierda
izquierda[i]=A[i];             //luego todo lo que recorrio i desde 0 nos es igual a lo que recorre A porque los dos comienzan en 0 asi q izuqiera[i] va a ser igual a A[i]
}                                // y ya tenemos los valores de la izquierda de a

int k = 0;                  //declaramos la variable k para despues aumentarla en derecha ahi van a ver
for (int j=i;j<A.length;j++){ // ahora hacemos un for en donde declaramos j para que recorra los valores deA donde los dejo i o donde quedaron en la izquierda 
                             // hasta que j nuestra variable sea menor que el tamano maximo del vector 
    derecha[k]= A[j];          //mientras tanto le vamos aumentando a j
k++;                           // entonces como les decia aumentan los valores de la derecha[k] y los valores de A siguen siendo recorridos por j donde los dejo la i o la izquierda
}

int orden []  = merge(Mergesort(izquierda),Mergesort(derecha));  // usamos la recursividad para que siga aplicando ese metodo a las subdivisiones de izquierda y derecha


    return orden;
}



public int[]merge ( int[]a, int[]b){   // este coso va a recibir dos subarreglos y los une en uno solo

int i=0;                        // en este caso uso i para a y j para b
int j=0;
int [] c = new int[a.length + b.length];// declaramos el vector c para asignar y ordenar

for (int k =0; k<c.length;k++){   //Un for que recorre va recorriendo k en c

if (a[i]<b[j]) {                   // aqui simplemente movemos los datos para ordenarlos por ejemplo
    c[k]=a[i];  // si el vector a es menor que el vector b en su misma pocicion lo cual debe de ser asi entonces c[k] le vamos a asignar el menor y movemos un espacio en a para q compare el siguiente
    i++;
}else {
   c[k]=b[j];  // igual aqui pero si a es mayor que b enonces como es de menor a mayor acuerdense entonces c[k] va a ser igual a (b)  y a j lo movemos un espacio para seguir cmomparando los valores de A y B en su misma pocicion
   j++;            // y asi susesivamente 
}

if (i==a.length) {          // ahoraa en este caso cuando por ejemplo A[i]  llegue a su ultimo valor entonces imprimimos los valores que quedaron en B[j] para eso abrimos un espacio en k y luego con un ciclo asignamos a c[k] los valores que faltaban de b[j] y abrimos un espacio en k para que los siga poniendo hasta que este llegue a su limite

  k++;

  for (j=j;j<b.length;j++){
c[k]=b[j];
k++;
  }

} else if (j==b.length) {   // aqui es lo mismo solo que cuando esta vez b[j] llegue a su maximo imprimimos los valores que quedaron de a[i] de la misma forma que explique arriba 

    k++;
  
    for (i=i;i<a.length;i++){
  c[k]=a[i];
  k++;
    }
  
  }         




}



    return c;  // aqui returna ya los datos ordenados jeje //ahi quedaria profe jaja  
}


}
