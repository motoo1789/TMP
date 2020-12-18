package resource;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.filebuffers.ITextFileBufferManager;
import org.eclipse.core.filebuffers.LocationKind;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class GetResource {

	private static GetResource resourceObjct = new GetResource();

	private GetResource() {

	}

	public static GetResource getInstance() {
		return resourceObjct;
	}



	public static IEditorPart getEditorPart() {

		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		IEditorPart editor = window.getActivePage().getActiveEditor();

		return editor;

	}

	public static IFile getIFile() {

		IEditorPart editor = getEditorPart();
		IEditorInput editorInput = editor.getEditorInput();
		IFile file = editorInput.getAdapter(IFile.class);
		return file;
	}

	public static IDocument getIDocument() {

		IDocument document;
		IFile file = getIFile();
		IPath path = file.getFullPath();
		ITextFileBufferManager manager = FileBuffers.getTextFileBufferManager();

		try {
			manager.connect(path, LocationKind.IFILE, null);
		} catch (CoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {

			ITextFileBuffer buffer = manager.getTextFileBuffer(path, LocationKind.IFILE);
			document = buffer.getDocument();

			try {
				buffer.commit(null, true);
			} catch (CoreException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} finally {
			try {
				manager.disconnect(path, LocationKind.IFILE, null);
			} catch (CoreException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		return document;

	}
}
