/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filterslab;

import org.opencv.core.Mat;

/**
 *
 * @author moh
 */
public interface Filter {

    public Mat applyFilter(Mat image);

}
