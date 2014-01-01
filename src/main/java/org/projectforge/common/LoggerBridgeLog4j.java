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

import org.apache.log4j.Level;
import org.apache.log4j.Priority;

/**
 * Implementation of log4j.
 * 
 * @author Kai Reinhard (k.reinhard@micromata.de)
 * 
 */
public class LoggerBridgeLog4j extends Logger
{
  // Ensuring that the class name of the caller class is used:
  private static final String CALLER_FQCN = LoggerBridgeLog4j.class.getName();

  private org.apache.log4j.Logger log;

  public LoggerBridgeLog4j()
  {
  }

  private LoggerBridgeLog4j(final Class< ? > clazz)
  {
    this.log = org.apache.log4j.Logger.getLogger(clazz);
  }

  /**
   * @see org.projectforge.common.Logger#isDebugEnabled()
   */
  @Override
  public boolean isDebugEnabled()
  {
    return log.isDebugEnabled();
  }

  /**
   * @see org.projectforge.common.Logger#info(java.lang.Object)
   */
  @Override
  public void debug(final Object message)
  {
    log(Level.DEBUG, message, null);
  }

  /**
   * @see org.projectforge.common.Logger#info(java.lang.Object)
   */
  @Override
  public void info(final Object message)
  {
    log(Level.INFO, message, null);
  }

  /**
   * @see org.projectforge.common.Logger#warn(java.lang.Object)
   */
  @Override
  public void warn(final Object message)
  {
    log(Level.WARN, message, null);
  }

  /**
   * @see org.projectforge.common.Logger#error(java.lang.Object)
   */
  @Override
  public void error(final Object message)
  {
    log(Level.ERROR, message, null);
  }

  /**
   * @see org.projectforge.common.Logger#error(java.lang.Object, java.lang.Throwable)
   */
  @Override
  public void error(final Object message, final Throwable t)
  {
    log(Level.ERROR, message, t);
  }

  /**
   * @see org.projectforge.common.Logger#fatal(java.lang.Object)
   */
  @Override
  public void fatal(final Object message)
  {
    log(Level.FATAL, message, null);
  }

  /**
   * @see org.projectforge.common.Logger#fatal(java.lang.Object, java.lang.Throwable)
   */
  @Override
  public void fatal(final Object message, final Throwable t)
  {
    log(Level.FATAL, message, t);
  }

  private void log(final Priority priority, final Object message, final Throwable t)
  {
    log.log(CALLER_FQCN, priority, message, t);
  }

  /**
   * @see org.projectforge.common.Logger#getInternalLogger(java.lang.String)
   */
  @Override
  protected Logger getInternalLogger(final Class< ? > clazz)
  {
    return new LoggerBridgeLog4j(clazz);
  }
}
