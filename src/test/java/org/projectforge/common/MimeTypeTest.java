/////////////////////////////////////////////////////////////////////////////
//
// Project ProjectForge Community Edition
//         www.projectforge.org
//
// Copyright (C) 2001-2014 Kai Reinhard (k.reinhard@micromata.de)
//
// ProjectForge is dual-licensed.
//
// This community edition is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License as published
// by the Free Software Foundation; version 3 of the License.
//
// This community edition is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
// Public License for more details.
//
// You should have received a copy of the GNU General Public License along
// with this program; if not, see http://www.gnu.org/licenses/.
//
/////////////////////////////////////////////////////////////////////////////

package org.projectforge.common;

import junit.framework.Assert;

import org.junit.Test;
import org.projectforge.common.MimeType;

/**
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public class MimeTypeTest
{
  @Test
  public void extensionTest()
  {
    Assert.assertNull(MimeType.getMimeType(null));
    Assert.assertNull(MimeType.getMimeType(""));
    Assert.assertNull(MimeType.getMimeType("file"));
    Assert.assertNull(MimeType.getMimeType("pdf"));
    Assert.assertNull(MimeType.getMimeType("pdf."));
    Assert.assertEquals(MimeType.PDF, MimeType.getMimeType(".pdf"));
    Assert.assertEquals(MimeType.PDF, MimeType.getMimeType("file.pdf"));
    Assert.assertEquals(MimeType.JPG, MimeType.getMimeType("picture.jpg"));
    Assert.assertEquals(MimeType.JPG, MimeType.getMimeType("picture.jpeg"));
  }
}
