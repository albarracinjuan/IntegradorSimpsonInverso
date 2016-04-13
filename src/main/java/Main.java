import edu.uniandes.ecos.IntegradorSimpsonInverso.modelo.BuscadorX;
import edu.uniandes.ecos.IntegradorSimpsonInverso.modelo.IntegradorSimpson;
import static spark.Spark.get;
import static spark.SparkBase.port;

/**
 * @name Main
 * @author Juan
 * @version 1.2
 * @date 07/04/2015
 * @description ejecuta los calculos de Integracion inversa.
 */
public class Main {

    //method
    /**
     * Metodo principal del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        port(Integer.valueOf(System.getenv("PORT")));

        BuscadorX buscadorX1 = new BuscadorX();
        BuscadorX buscadorX2 = new BuscadorX();
        BuscadorX buscadorX3 = new BuscadorX();

        StringBuilder response = new StringBuilder();

        try {
            double xActual1 = buscadorX1.buscarX(0.20, 1.0, 6, 10);
            double xActual2 = buscadorX2.buscarX(0.45, 1.0, 15, 10);
            double xActual3 = buscadorX3.buscarX(0.495, 1.0, 4, 10);

            response.append("<style type=\"text/css\">");
            response.append(".tg  {border-collapse:collapse;border-spacing:0;}");
            response.append(".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}");
            response.append(".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}");
            response.append(".tg .tg-yfvh{font-weight:bold;font-style:italic;vertical-align:top}");
            response.append(".tg .tg-9hbo{font-weight:bold;vertical-align:top}");
            response.append(".tg .tg-yw4l{vertical-align:top}");
            response.append("</style>");
            response.append("<table class=\"tg\">");
            response.append("<tr>");
            response.append("<th class=\"tg-9hbo\" colspan=\"2\">Test</th>");
            response.append("<th class=\"tg-9hbo\">Expected <br>Value</th>");
            response.append("<th class=\"tg-9hbo\">Actual<br>Value</th>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-yfvh\">P</td>");
            response.append("<td class=\"tg-yfvh\">dof</td>");
            response.append("<td class=\"tg-yfvh\">X</td>");
            response.append("<td class=\"tg-yfvh\">X</td>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-yw4l\">0.20</td>");
            response.append("<td class=\"tg-yw4l\">6</td>");
            response.append("<td class=\"tg-yw4l\">0.55338</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(IntegradorSimpson.redondear(xActual1, 5));
            response.append("</td>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-yw4l\">0.45</td>");
            response.append("<td class=\"tg-yw4l\">15</td>");
            response.append("<td class=\"tg-yw4l\">1.75305</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(IntegradorSimpson.redondear(xActual2, 5));
            response.append("</td>");
            response.append("</tr>");
            response.append("<tr>");
            response.append("<td class=\"tg-yw4l\">0.495</td>");
            response.append("<td class=\"tg-yw4l\">4</td>");
            response.append("<td class=\"tg-yw4l\">4.60409</td>");
            response.append("<td class=\"tg-yw4l\">");
            response.append(IntegradorSimpson.redondear(xActual3, 5));
            response.append("</td>");
            response.append("</tr>");
            response.append("</table>");

            get("/", (req, res) -> response.toString());
        } catch (Exception ex) {
            response.append("No se ha podido integrar la funcion debido a la siguiente excepcion: ");
            response.append(ex.getMessage());
            get("/", (req, res) -> response.toString());
        }
    }
}

