/*******************************************************************************
 * Copyright (C) 2016  ATOS Spain S.A.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *      Mateusz Radzimski (ATOS, ARI, Knowledge Lab)
 *      Iván Martínez Rodriguez (ATOS, ARI, Knowledge Lab)
 *      María Angeles Sanguino Gonzalez (ATOS, ARI, Knowledge Lab)
 *      Jose María Fuentes López (ATOS, ARI, Knowledge Lab)
 *      Jorge Montero Gómez (ATOS, ARI, Knowledge Lab)
 *      Ana Luiza Pontual Costa E Silva (ATOS, ARI, Knowledge Lab)
 *      Miguel Angel Tinte García (ATOS, ARI, Knowledge Lab)
 *      
 *******************************************************************************/
package atos.knowledgelab.capture.bean.exception;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

public class CaptureException extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaptureException(){
		super();
	}
	
	//Constructor that accepts a message
    public CaptureException(String message) {
       super(message);
    }

    public CaptureException(String message, Throwable cause) { 
    	super(message, cause); 
    }
    
    public CaptureException(Throwable cause) { 
    	super(cause); 
    }
    
    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public Throwable getCause() {
        return super.getCause();
    }
    
}
