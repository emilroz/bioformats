/*
 * ome.xml.r201004.enums.handlers.NamingConventionHandler
 *
 *-----------------------------------------------------------------------------
 *
 *  Copyright (C) 2005-@year@ Open Microscopy Environment
 *      Massachusetts Institute of Technology,
 *      National Institutes of Health,
 *      University of Dundee,
 *      University of Wisconsin-Madison
 *
 *
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with this library; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *-----------------------------------------------------------------------------
 */

/*-----------------------------------------------------------------------------
 *
 * THIS IS AUTOMATICALLY GENERATED CODE.  DO NOT MODIFY.
 * Created by callan via xsd-fu on 2010-05-25 12:10:00.232400
 *
 *-----------------------------------------------------------------------------
 */

package ome.xml.r201004.enums.handlers;

import java.util.Hashtable;
import java.util.List;

import ome.xml.r201004.enums.Enumeration;
import ome.xml.r201004.enums.EnumerationException;
import ome.xml.r201004.enums.NamingConvention;

/**
 * Enumeration handler for NamingConvention.
 *
 * <dl><dt><b>Source code:</b></dt>
 * <dd><a href="https://skyking.microscopy.wisc.edu/trac/java/browser/trunk/components/bio-formats/src/loci/formats/enums/handler/NamingConventionHandler.java">Trac</a>,
 * <a href="https://skyking.microscopy.wisc.edu/svn/java/trunk/components/bio-formats/src/loci/formats/enums/handler/NamingConventionHandler.java">SVN</a></dd></dl>
 */
public class NamingConventionEnumHandler implements IEnumerationHandler {

  // -- Fields --

  /** Every NamingConvention value must match one of these patterns. */
  private static final Hashtable<String, String> patterns = makePatterns();

  private static Hashtable<String, String> makePatterns() {
    Hashtable<String, String> p = new Hashtable<String, String>();
    p.put("^\\s*letter\\s*", "letter");
    p.put("^\\s*number\\s*", "number");
    return p;
  }

  // -- IEnumerationHandler API methods --

  /* @see IEnumerationHandler#getEnumeration(String) */
  public Enumeration getEnumeration(String value)
    throws EnumerationException {
    for (String pattern : patterns.keySet()) {
      if (value.toLowerCase().matches(pattern.toLowerCase())) {
        String v = patterns.get(pattern);
        return NamingConvention.fromString(v);
      }
    }
    throw new EnumerationException(this.getClass().getName() +
     " could not find enumeration for " + value);
  }

  /* @see IEnumerationHandler#getEntity() */
  public Class<? extends Enumeration> getEntity() {
    return NamingConvention.class;
  }

}