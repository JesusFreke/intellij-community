package com.intellij.lang.ant;

import com.intellij.lang.Language;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.tree.IFileElementType;
import org.jetbrains.annotations.NonNls;

public class AntSupport implements ApplicationComponent {

  private static LanguageFileType ourAntFileType = null;
  private static Language ourAntLanguage = null;

  public AntSupport(FileTypeManager fileTypeManager) {
    fileTypeManager.registerFileType(getFileType(), new String[]{AntFileType.DEFAULT_EXTENSION});
  }

  public static LanguageFileType getFileType() {
    if (ourAntFileType == null) {
      ourAntFileType = new AntFileType();
    }
    return ourAntFileType;
  }

  public static Language getLanguage() {
    if (ourAntLanguage == null) {
      ourAntLanguage = getFileType().getLanguage();
    }
    return ourAntLanguage;
  }

  @NonNls
  public String getComponentName() {
    return "AntSupportComponent";
  }

  public void initComponent() {
  }

  public void disposeComponent() {
  }
}
