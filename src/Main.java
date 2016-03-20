/*
 * The MIT License
 *
 * Copyright 2016 Bryan James.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package CryptoSum;

/**
 * <h1>Main Class</h1>
 * <p>This file is a part of CryptoSum. Licensed with MIT license.</p>
 * <p>This file is holds the main class. This is the first class to be called when
 * the JAR file (or the program) is invoked.</p>
 * 
 * @author Bryan James
 * @since 3-20-2016
 * @version 1.0
 */
public class 
    Main 
{
    
    /**
     * <h1>Main Method</h1>
     * @param args CryptoSum does not currently support main arguments
     */
    public static void 
        main(String args[]) 
    {
        
        UserInterface ui = new UserInterface();
        ui.launchFrame ();
        
    } // main()
    
} // Class Main
