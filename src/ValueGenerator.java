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
 * <b><u>Imported Packages</u></b>
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * <h1>ValueGenerator Class</h1>
 * <p>This file is a part of CryptoSum. Licensed with MIT license.</p>
 * <p>This file holds all the processing portion of the program.
 * This class holds the functions for computation, and outputs for the
 * user interface.</p>
 * 
 * @author Bryan James
 * @since 3-20-2016
 * @version 1.0
 */
public class 
    ValueGenerator 
{
    
    private FileInputStream file;
    private String          algorithm       =   "";
    private String          hashValue       =   "";
    private String          statusInfo      =   "";
    private boolean         isRunning       =   true;
    
    protected 
        ValueGenerator( File file, String algorithm ) 
            throws FileNotFoundException
    {
        this.file       =   new FileInputStream (file);
        this.algorithm  =   algorithm;
        
        this.compute();
    } // Constructor ValueGenerator()
        
    private void compute() {
        try {
            MessageDigest digest    =   MessageDigest.getInstance( algorithm );
            byte arrayOfBytes[]     =   new byte[1024];
            byte hashedBytes[];
            int bytesPoint = -1;
            
            while( (bytesPoint = file.read( arrayOfBytes )) != -1) {
                digest.update( arrayOfBytes, 0, bytesPoint );
            }
            
            hashedBytes = digest.digest();
            this.hashValue = bytesToHexString (hashedBytes);
        } catch(NoSuchAlgorithmException nsae) {
            isRunning = false;
            statusInfo = "Algorithm is not yet supported!";
            System.err.println ("Algorithm is not yet supported!\n" + nsae);
        } catch(IOException ioe) {
            isRunning = false;
            statusInfo = "File cannot be found!\n";
            System.err.println ("File cannot be found!\n" + ioe);
        }
    } // compute()
    
    private String bytesToHexString( byte arrayOfBytes [] ) {
        StringBuffer hexVal = new StringBuffer();
        
        for (int count = 0; count < arrayOfBytes.length; count++) {
            hexVal.append( Integer.toString((arrayOfBytes[count] & 0xff) + 0x100, 16).substring(1) );
        }
        
        return (new String (hexVal));
    } // bytesToHexString()
    
    protected boolean getStatus() {
        return (isRunning);
    } // getStatus()
    
    protected String getStatusInfo() {
        return (statusInfo);
    } // getStatusInfo()
    
    protected String getHash() {
        return (hashValue);
    } // getHash()
    
    protected boolean compareFile( File hashFile ) throws FileNotFoundException {
        boolean retVal = false;
        Scanner scan = new Scanner(hashFile);
        String hashData [] = scan.nextLine().split(" ");
        
        if (hashData[0].equals(hashValue)) {
            retVal = true;
        }
        
        return (retVal);
    } // compareFile()
    
} // Class ValueGenerator
