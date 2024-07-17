/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thien.ws1.tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Called by the container to invoke this tag. The implementation of this method
 * is provided by the tag library developer, and handles all tag processing,
 * body iteration, etc.
 *
 * @throws JspException if an error occurs while processing the tag
 * 
 * @author Thienlm30
 */
public class ShowProductCard extends SimpleTagSupport {

    private String name;
    private Integer price;
    private double discount;
    private String image;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            
             // Calculate the discounted price
            double discountedPrice = (double) price - (price * discount / 100);
            
            // Generate the product card HTML
            out.print("<div class='group w-80 rounded-lg overflow-hidden shadow-lg bg-white m-4 relative hover:shadow-xl transition duration-300 ease-in-out transform hover:-translate-y-1 hover:scale-105'>");
            out.print("<div class='w-full h-80 overflow-hidden'>");
            out.print("<img class='object-cover w-full h-full' src='." + image + "' alt='" + name + "'>");
            out.print("</div>");
            out.print("<div class='px-6 py-4'>");
            out.print("<div class='font-bold text-sm mb-2'>");
            out.print(name);
            out.print("</div>");
            out.print("<div class='flex justify-between items-center'>");
            out.print("<div>");
            
             // Display price with discount if applicable
            if (discount != 0) {
                out.print("<span class='text-gray-600 text-sm line-through mr-2'>" + price + " VND</span>");
                out.print("<span class='text-green-600 text-sm font-semibold'>" + discountedPrice + " VND</span>");
                out.print("<span class='text-red-600 text-sm ml-2'>" + discount + "% OFF</span>");
            } else {
                out.print("<span class='text-green-600 text-sm font-semibold'>" + price + " VND</span>");
            }
            out.print("</div>");
            out.print("</div>");
            out.print("</div>");
            out.print("</div>");

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ShowProduct tag", ex);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
