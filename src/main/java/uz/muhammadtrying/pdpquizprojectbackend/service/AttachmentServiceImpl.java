package uz.muhammadtrying.pdpquizprojectbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.muhammadtrying.pdpquizprojectbackend.entity.Attachment;
import uz.muhammadtrying.pdpquizprojectbackend.entity.AttachmentContent;
import uz.muhammadtrying.pdpquizprojectbackend.interfaces.AttachmentService;
import uz.muhammadtrying.pdpquizprojectbackend.repo.AttachmentContentRepository;
import uz.muhammadtrying.pdpquizprojectbackend.repo.AttachmentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentContentRepository attachmentContentRepository;
    private final AttachmentRepository attachmentRepository;


    @Override
    public Optional<AttachmentContent> getPhotoById(Integer attachmentId) {
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(attachmentId);
        if (attachmentOptional.isEmpty()) {
            return Optional.empty();
        }
        Attachment attachment = attachmentOptional.get();
        AttachmentContent attachmentContent = attachmentContentRepository.findByAttachment(attachment);
        return Optional.ofNullable(attachmentContent);
    }
}