/////////////////////////////////////////////////////////////////////////////
//
// Project ProjectForge Community Edition
//         www.projectforge.org
//
// Copyright (C) 2001-2013 Kai Reinhard (k.reinhard@micromata.de)
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

package org.projectforge.core;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for properties of DO classes for handling i18n keys and Excel-Exports.
 * @author Kai Reinhard (k.reinhard@micromata.de)
 */
@Target({ FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PropertyInfo {
  /**
   * i18n key.
   */
  String i18nKey();

  /**
   * @see PropertyType
   */
  PropertyType type() default PropertyType.UNSPECIFIED;

  /**
   * For own types if {@link PropertyType} doesn't provide needed type.
   * @return
   */
  String customType() default "";
}
